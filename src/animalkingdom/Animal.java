package animalkingdom;

abstract class Animal {

    protected static int maxId = 0;
    protected int id;
    protected String name;
    protected int year;
    public String eat() {
        return "Eating";
    };

    public Animal(String name, int year) {
        id = maxId;
        maxId += 1;
        this.name = name;
        this.year = year;
    }

    abstract String move();
    abstract String breath();
    abstract String reproduce();

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Animals{"+"id="+id+", "+"name='"+name+"', "+"yearNamed="+year+"}";
    }
}