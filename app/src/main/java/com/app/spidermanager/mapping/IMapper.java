package com.app.spidermanager.mapping;

/**
 * Контракт для маппингов
 * @param <In> Входящий тип
 * @param <Out> Выходной тип
 */
public interface IMapper<In, Out>{
    /**
     * Преобразует объект типа In в тип Out
     * @param input объект для преобразования
     * @return преобразованный объект
     */
    Out map(In input);
}
