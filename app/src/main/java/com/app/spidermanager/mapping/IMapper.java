package com.app.spidermanager.mapping;

public interface IMapper<In, Out>{
    Out map(In input);
}
