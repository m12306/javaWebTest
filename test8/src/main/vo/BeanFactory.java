package main.vo;

public class BeanFactory {
    public static UserService getUserService(){
        return new UserService();
    }
    public  CategoryService getCategoryService(){
        return new CategoryService();
    }
}
