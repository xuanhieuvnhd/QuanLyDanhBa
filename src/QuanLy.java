public interface QuanLy <E>{
    void add(E e);

    void display();

    int search(String name);

    void edit(String name, E e);

    void delete(String name);
}
