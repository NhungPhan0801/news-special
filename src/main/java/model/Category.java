package model;

public class Category {
    private Long categoryId;
    private String  categoryName;

    public Long getCategoryId(long id) {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName(String name) {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
