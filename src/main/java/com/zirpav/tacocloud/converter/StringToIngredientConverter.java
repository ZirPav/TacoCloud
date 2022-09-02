package com.zirpav.tacocloud.converter;

import java.util.Optional;

import com.zirpav.tacocloud.model.Ingredient;
import com.zirpav.tacocloud.model.IngredientUDT;
import com.zirpav.tacocloud.repo.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToIngredientConverter implements Converter<String, IngredientUDT> {

    private IngredientRepository ingredientRepository;

    public StringToIngredientConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientUDT convert(String id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            return null;
        }

        return ingredient.map(i -> new IngredientUDT(i.getName(), i.getType())).get();
    }

}
