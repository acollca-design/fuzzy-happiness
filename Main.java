import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static final int PORT = 8080;
    static final Path STATIC = Path.of("static");
    static final int MIN = -99999, MAX = 99999, MAX_EXP = 1000;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/api/calc", Main::handleCalc);
        server.createContext("/", Main::handleStatic);
        server.start();
        System.out.println("→ http://localhost:" + PORT);
    }

    // ---------- API ----------
    static void handleCalc(HttpExchange ex) throws IOException {
        if (!"POST".equals(ex.getRequestMethod())) {
            send(ex, 405, "text/plain", "Método no permitido");
            return;
        }
        String body = new String(ex.getRequestBody().readAllBytes());
        String a = extract(body, "a");
        String b = extract(body, "b");
        String op = extract(body, "op");

        try {
            long va = validar(a);
            long vb = validar(b);
            BigInteger r = switch (op == null ? "" : op) {
                case "suma"           -> BigInteger.valueOf(va).add(BigInteger.valueOf(vb));
                case "resta"          -> BigInteger.valueOf(va).subtract(BigInteger.valueOf(vb));
                case "multiplicacion" -> BigInteger.valueOf(va).multiply(BigInteger.valueOf(vb));
                case "potencia"       -> potencia(va, vb);
                default -> throw new IllegalArgumentException("Operación no permitida");
            };
            send(ex, 200, "application/json", "{\"ok\":true,\"result\":\"" + r + "\"}");
        } catch (IllegalArgumentException e) {
            send(ex, 200, "application/json", "{\"ok\":false,\"error\":\"" + esc(e.getMessage()) + "\"}");
        }
    }

    static long validar(String s) {
        if (s == null || !s.matches("-?\\d+"))
            throw new IllegalArgumentException("Debe ser un número entero");
        long v = Long.parseLong(s);
        if (v < MIN || v > MAX)
            throw new IllegalArgumentException("Debe estar entre " + MIN + " y " + MAX);
        return v;
    }

    static BigInteger potencia(long base, long exp) {
        if (exp < 0) throw new IllegalArgumentException("El exponente no puede ser negativo");
        if (exp > MAX_EXP) throw new IllegalArgumentException("Exponente máximo: " + MAX_EXP);
        return BigInteger.valueOf(base).pow((int) exp);
    }

    static String extract(String json, String key) {
        Matcher m = Pattern.compile("\"" + key + "\"\\s*:\\s*\"([^\"]*)\"").matcher(json);
        return m.find() ? m.group(1) : null;
    }

    static String esc(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    // ---------- Estáticos ----------
    static void handleStatic(HttpExchange ex) throws IOException {
        String path = ex.getRequestURI().getPath();
        if (path.equals("/") || path.isEmpty()) path = "/index.html";

        Path file = STATIC.resolve(path.substring(1)).normalize();
        if (!file.startsWith(STATIC) || !Files.exists(file)) {
            send(ex, 404, "text/plain", "No encontrado");
            return;
        }
        String mime = switch (ext(path)) {
            case "html" -> "text/html; charset=UTF-8";
            case "css"  -> "text/css; charset=UTF-8";
            case "js"   -> "application/javascript; charset=UTF-8";
            default     -> "application/octet-stream";
        };
        byte[] data = Files.readAllBytes(file);
        ex.getResponseHeaders().set("Content-Type", mime);
        ex.sendResponseHeaders(200, data.length);
        try (OutputStream os = ex.getResponseBody()) { os.write(data); }
    }

    static String ext(String p) {
        int i = p.lastIndexOf('.');
        return i < 0 ? "" : p.substring(i + 1);
    }

    static void send(HttpExchange ex, int status, String mime, String txt) throws IOException {
        byte[] data = txt.getBytes();
        ex.getResponseHeaders().set("Content-Type", mime + "; charset=UTF-8");
        ex.sendResponseHeaders(status, data.length);
        try (OutputStream os = ex.getResponseBody()) { os.write(data); }
    }
}