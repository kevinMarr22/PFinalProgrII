package com.example.notas_android;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.notas_android.db.entity.NotaEntity;

import java.util.List;

public class NuevaNotaDialogViewModel extends AndroidViewModel {
    private LiveData<List<NotaEntity>> allNotas;
    private NotaRepository notaRepository;

    public NuevaNotaDialogViewModel(Application application){
        super(application);
        notaRepository = new NotaRepository(application);
        allNotas = notaRepository.getAll();
    }

    public LiveData<List<NotaEntity>> getAllNotas(){ return allNotas;}
    public void insertarNota(NotaEntity nuevaNotaEntity){notaRepository.insert(nuevaNotaEntity);}
    public void updateNota(NotaEntity notaActualizarEntity){
        notaRepository.update(notaActualizarEntity);
    }
}