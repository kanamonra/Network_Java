class Pokemon
{
    protected String name = null ;
    protected String owner = null ;
    protected String skills = null ;
    protected int count = 0;
    public Pokemon()
    {
        System.out.println("I'm a super default constructor");
    }
    public Pokemon(String name, String owner, String skills)
    {
       this.name = name;
       this.owner = owner;
       this.skills = skills;
    }
    public void show_info()
    {
        System.out.printf("%s의 포켓몬이 사용 가능한 스킬", skills);
    }
}

class Pikachu extends Pokemon
{
    private String name;
    private String skills;

    public Pikachu()
    {
        System.out.println("I'm a pikachu default constructor");
    }
    public Pikachu(String name, String owner, String skills)
    {
        super(name, owner, skills);

    }
}
