package package_09;

public interface MyList {
    public void add(Object element);
    public void Delete(Object element);
    public void Delete(int index);
    public void update(int index , Object element);
    public int ElementAt(Object element);
    public Object indexAt(int index);
    public boolean contains(Object element);
}
