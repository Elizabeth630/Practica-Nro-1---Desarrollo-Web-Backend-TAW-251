package com.universidad.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.universidad.model.Estudiante;

@Repository
public class EstudianteRepository {
    private final Map<Long, Estudiante> estudiantes = new ConcurrentHashMap<>();
    private final AtomicLong idContador = new AtomicLong(1);

    public Estudiante save(Estudiante estudiante){
        if(estudiante.getId() == null){
            estudiante.setId(idContador.getAndIncrement());
        }
        estudiantes.put(estudiante.getId(), estudiante);
        return estudiante;
    }
    public List<Estudiante> findAll(){
        return new ArrayList<>(estudiantes.values());
    }
    public void deleteById(Long id){
        estudiantes.remove(id);
    }
    //metodo para inicializar algunos elementos de ejemplo, con la ayuda de Lombok
    public void init(){
        Estudiante estudiante1 = Estudiante.builder()
                    .nombre("Juan")
                    .apellido("Pérez")
                    .email("juan.perez.@example.com")
                    .fechaNacimiento(LocalDate.of(2000,5,15))
                    .numeroInscripcion("S001")
                    .build();
        

        Estudiante estudiante2 = Estudiante.builder()
                    .nombre("María")
                    .apellido("Gonzáles")
                    .email("maria.gonzales.@example.com")
                    .fechaNacimiento(LocalDate.of(2001,8,22))
                    .numeroInscripcion("S002")
                    .build();

        save(estudiante1);
        save(estudiante2);
    }

    public Optional<Estudiante> findById(Long id){
        return Optional.ofNullable(estudiantes.get(id));
    }

    public boolean existById(Long id){
        return estudiantes.containsKey(id);
    }

}
