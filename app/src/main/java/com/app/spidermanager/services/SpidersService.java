package com.app.spidermanager.services;

import android.content.Context;

import com.app.spidermanager.mapping.CreateSpiderModelToSpiderMapper;
import com.app.spidermanager.mapping.SpiderToSpiderItemModelMapper;
import com.app.spidermanager.mapping.UpdSpiderModelToSpiderMapper;
import com.app.spidermanager.models.CreateSpiderModel;
import com.app.spidermanager.models.SpiderItemModel;
import com.app.spidermanager.models.UpdSpiderModel;
import com.app.spidermanager.repositories.SpidersRepository;

import java.util.ArrayList;

public class SpidersService {
    protected SpidersRepository spidersRepository;

    public SpidersService(Context context) {
        spidersRepository = new SpidersRepository(context);
    }

    public ArrayList<SpiderItemModel> getAll(){
        ArrayList<SpiderItemModel> items = new ArrayList<>();
        spidersRepository.all().forEach(spider ->
                items.add(new SpiderToSpiderItemModelMapper().map(spider)));
        return items;
    }

    public CreateSpiderModel create(CreateSpiderModel createSpiderModel){
        spidersRepository.create(new CreateSpiderModelToSpiderMapper().map(createSpiderModel));
        return createSpiderModel;
    }

    public UpdSpiderModel update(UpdSpiderModel updSpiderModel){
        spidersRepository.update(new UpdSpiderModelToSpiderMapper().map(updSpiderModel));
        return updSpiderModel;
    }

    public void delete(int id){
        spidersRepository.delete(id);
    }
}


