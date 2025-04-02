package com.universidad.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Estudiante;
import com.universidad.repository.EstudianteRepository;
import com.universidad.service.IEstudianteService;

import jakarta.annotation.PostConstruct;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
    private final EstudianteRepository estudianteRepository;

    
    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;

    }
    @PostConstruct
    public void init(){
        estudianteRepository.init();
    }

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes(){
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for(Estudiante estudiante : estudiantes){
            estudiantesDTO.add(convertToDTO(estudiante));
        }
        return estudiantesDTO;
    }



//**** */
    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO){
        //convertir DTO  a entidad
        Estudiante estudiante = convertToEntity(estudianteDTO);
        //guardar estudiante
        Estudiante savedEstudiante = estudianteRepository.save(estudiante);

        //convertir entidad guardada a DTO y retornar
        return convertToDTO(savedEstudiante);
    }

    public List<EstudianteDTO> getAllEstudents(){
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
        for(Estudiante estudiante : estudiantes){
            estudiantesDTO.add(convertToDTO(estudiante));
        }
        return estudiantesDTO;
    }
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO){
        Estudiante estudianteExistente = estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        estudianteExistente.setNombre(estudianteDTO.getNombre());
        estudianteExistente.setApellido(estudianteDTO.getApellido());
        estudianteExistente.setEmail(estudianteDTO.getEmail());
        estudianteExistente.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
        estudianteExistente.setNumeroInscripcion(estudianteDTO.getNumeroInscripcion());

        //Guardar el estudiante actualizado
        Estudiante estudianteGuardado = estudianteRepository.save(estudianteExistente);
        return convertToDTO(estudianteGuardado);
    }

    @Override
    public void eliminarEstudiante(Long id){
        if(!estudianteRepository.existById(id)){
            throw new RuntimeException("Estudiante no encontrado");
        }
        estudianteRepository.deleteById(id);
    }

    /* 
    public void deleteStudent(){
        //eliminar estudiante
        estudianteRepository.deleteById(id);
    }*/

    //metodo auxiliar para convertir entidad a DTO
    private EstudianteDTO convertToDTO(Estudiante estudiante){
        return EstudianteDTO.builder()
                .id(estudiante.getId())
                .nombre(estudiante.getNombre())
                .apellido(estudiante.getApellido())
                .email((estudiante.getEmail()))
                .fechaNacimiento(estudiante.getFechaNacimiento())
                .numeroInscripcion(estudiante.getNumeroInscripcion())
                .build();
    }

    //metodo auxiliar para convertir de DTO a entidad
    private Estudiante convertToEntity(EstudianteDTO estudianteDTO){
        return Estudiante.builder()
                .id(estudianteDTO.getId())
                .nombre(estudianteDTO.getNombre())
                .apellido(estudianteDTO.getApellido())
                .email(estudianteDTO.getEmail())
                .fechaNacimiento(estudianteDTO.getFechaNacimiento())
                .numeroInscripcion(estudianteDTO.getNumeroInscripcion())
                .build();
    }
}
