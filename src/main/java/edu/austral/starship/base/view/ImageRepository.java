package edu.austral.starship.base.view;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.model.entity.EntityType;
import processing.core.PImage;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: brianfroschauer
 * Date: 04/11/2018
 */
public class ImageRepository {

    private final Map<EntityType, PImage> repository = new HashMap<>();
    private final ImageLoader imageLoader;

    public ImageRepository(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public void add(EntityType entityType, String imagePath) {
        final PImage image = imageLoader.load(imagePath);
        repository.put(entityType, image);
    }

    public PImage get(EntityType entityType) {
        return repository.get(entityType);
    }

    public void remove(EntityType entityType) {
        repository.remove(entityType);
    }
}