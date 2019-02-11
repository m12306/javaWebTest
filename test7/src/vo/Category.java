package vo;

/**
 * Description: 书籍类别实体类
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/11/27 18:58
 * @version : 1.0
 */
public class Category {
    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
