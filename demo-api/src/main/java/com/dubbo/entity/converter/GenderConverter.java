package com.dubbo.entity.converter;

import com.dubbo.entity.Gender;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.AttributeConverter;

/**
 * Created by lkp on 2014/12/27.
 */
public class GenderConverter implements AttributeConverter<Gender, Integer>, Converter<String, Gender> {
    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        return gender.getValue();
    }

    @Override
    public Gender convertToEntityAttribute(Integer i) {
        return Gender.get(i);
    }

    @Override
    public Gender convert(String s) {
        return Gender.get(Integer.parseInt(s));
    }
}
