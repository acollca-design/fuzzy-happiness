const inputA = document.getElementById('a');
const inputB = document.getElementById('b');
const resultado = document.getElementById('resultado');

document.querySelectorAll('button[data-op]').forEach(btn => {
    btn.addEventListener('click', () => calcular(btn.dataset.op));
});

async function calcular(op) {
    const a = inputA.value.trim();
    const b = inputB.value.trim();

    if (!a || !b) {
        mostrarError('Introduce ambos números');
        return;
    }

    try {
        const res = await fetch('/api/calc', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ a, b, op })
        });
        const data = await res.json();
        if (data.ok) mostrarResultado(data.result);
        else mostrarError(data.error);
    } catch {
        mostrarError('Error de conexión con el servidor');
    }
}

function mostrarResultado(r) {
    resultado.className = 'resultado ok';
    resultado.innerHTML = `<strong>${r}</strong>`;
}

function mostrarError(msg) {
    resultado.className = 'resultado error';
    resultado.textContent = msg;
}