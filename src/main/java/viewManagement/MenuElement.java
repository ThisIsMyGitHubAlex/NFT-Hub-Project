package viewManagement;

public class MenuElement {

    private String name;
    private String view;

    public MenuElement(String name, String view) {
        this.name = name;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getView() {
        return view;
    }

    public void setview(String view) {
        this.view = view;
    }
}
