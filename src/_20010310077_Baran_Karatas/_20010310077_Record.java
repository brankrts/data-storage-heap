package _20010310077_Baran_Karatas;


public class _20010310077_Record {
    private Long id;
    private String name;
    private String surName;

    public _20010310077_Record(Long id, String name, String surName) {
        this.name = name;
        this.surName = surName;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getsurName() {
        return this.surName;
    }

    public Long getId() {
        return this.id;
    }

    public void getInfo() {

        System.out.println("TC: " + getId() + "\nIsim: " + getName() + "\nSoyisim: " + getsurName());

    }

}
