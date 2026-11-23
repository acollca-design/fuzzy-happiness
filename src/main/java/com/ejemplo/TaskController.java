package com.ejemplo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final List<Task> tasks = new CopyOnWriteArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    // GET /api/tasks
    @GetMapping
    public List<Task> getAll() {
        return tasks;
    }

    // POST /api/tasks
    @PostMapping
    public Task create(@RequestBody Task task) {
        task.setId(counter.incrementAndGet());
        tasks.add(task);
        return task;
    }

    // PUT /api/tasks/{id}
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task updated) {
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                t.setTitle(updated.getTitle());
                t.setDone(updated.isDone());
                return t;
            }
        }
        throw new RuntimeException("Tarea no encontrada");
    }

    // DELETE /api/tasks/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}