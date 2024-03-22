package hieu_nguyendinh.list_animals;

public class Animal {
    String name;
    String image;
    String description;

    public Animal(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
