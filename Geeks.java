public class Geeks {
    public String name;
    public int Id;

    public Geeks()
    {
        this.name = name;
        this.Id = Id;
    }

    @Override
    public int hashCode(){

        return this.Id;

    }

    @Override
    public boolean equals(Object obj)
    {
        if(this==obj)
        {
            return true;
        }

        if(obj==null || obj.getClass()!= this.getClass())
            return false;

        Geeks geek = (Geeks)obj;

        return (this.name==geek.name);

    }
}
