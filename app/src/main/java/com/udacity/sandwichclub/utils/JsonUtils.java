package com.udacity.sandwichclub.utils;

import android.util.JsonReader;
import android.util.JsonWriter;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject jsonObject = new JSONObject(json);

        JSONObject name = jsonObject.getJSONObject("name");
        String mainName = name.getString("mainName");

        JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAsList = new ArrayList<>();

        if (alsoKnownAs != null) {
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }
        }


        String placeOfOrigin = jsonObject.getString("placeOfOrigin");
        String description = jsonObject.getString("description");
        String image = jsonObject.getString("image");
        JSONArray ingredients = jsonObject.getJSONArray("ingredients");

        List<String> ingredientsList = new ArrayList<>();
        if (ingredients != null) {
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }
        }

        Sandwich sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
        return sandwich;
    }
}
