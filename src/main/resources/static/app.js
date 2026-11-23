const lista = document.getElementById('lista');
const form = document.getElementById('form');
const input = document.getElementById('titulo');

const API = '/api/tasks';

async function cargarTareas() {
    const res = await fetch(API);
    const tareas = await res.json();

    lista.innerHTML = '';
    tareas.forEach(t => {
        const li = document.createElement('li');
        if (t.done) li.classList.add('done');

        const check = document.createElement('input');
        check.type = 'checkbox';
        check.checked = t.done;
        check.addEventListener('change', () => toggle(t));

        const span = document.createElement('span');
        span.textContent = t.title;

        const btn = document.createElement('button');
        btn.textContent = '✕';
        btn.addEventListener('click', () => borrar(t.id));

        li.append(check, span, btn);
        lista.appendChild(li);
    });
}

async function crearTarea(titulo) {
    await fetch(API, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title: titulo, done: false })
    });
    cargarTareas();
}

async function toggle(t) {
    await fetch(`${API}/${t.id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title: t.title, done: !t.done })
    });
    cargarTareas();
}

async function borrar(id) {
    await fetch(`${API}/${id}`, { method: 'DELETE' });
    cargarTareas();
}

form.addEventListener('submit', e => {
    e.preventDefault();
    const titulo = input.value.trim();
    if (!titulo) return;
    crearTarea(titulo);
    input.value = '';
});

cargarTareas();