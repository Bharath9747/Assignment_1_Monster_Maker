package Monster_Maker;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static Monster_Maker.Monster.createBaby;

public class MainMaster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Monster> monsterSet = new HashSet<>();
        Set<Monster> babyMonsterSet  = new HashSet<>();
        System.out.println("Existing Attributes : ");
        Monster monster1 = new Monster();
        monster1.displayAtrribute();


        System.out.println("Enter the n Monsters : ");

        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Monster : "+(i+1));
            //Color of Eye
            String s1 = sc.next();
            //Feather Color
            String s2 = sc.next();
            //Magical Ability
            boolean s3 = sc.nextBoolean();
            //Size
            int s4 = sc.nextInt();
            //Strength
            int s5 = sc.nextInt();
            //Durability
            int s6 = sc.nextInt();
            //Aggressionlevel
            int s7 = sc.nextInt();

            Monster monster = new Monster(s1,s2,s3,s4,s5,s6,s7);
            System.out.println("Do you want Attribute(Y/N)");
            String ch = sc.next();
            if(ch.equals("Y"))
            {
                String attributeName = sc.next();
                String attributeValue = sc.next();
                monster.setAdditionalAttribute(attributeName,attributeValue);
            }
            if(monsterSet.add(monster)) {
                System.out.println("Monster : " + (i + 1) + " Created");
                if(monsterSet.size()==1)
                    continue;
                else{
                    Set<Monster> temp = createBaby(monsterSet);
                    for(Monster m : temp)
                    {
                        if(monsterSet.add(m))
                        {
                            monsterSet.remove(m);
                            babyMonsterSet.add(m);

                        }
                        else
                        {
                            System.out.println("Already Baby Monster Created "+m);
                        }
                    }
                    System.out.println("Monster List After Monster "+(i+1)+" Added");
                    monsterSet.stream().forEach(System.out::println);
                    if(babyMonsterSet.size()!=0)
                    {
                    System.out.println("Baby Monster List After Monster "+(i+1)+" Added");
                    babyMonsterSet.stream().forEach(System.out::println);
                }}

            }
            else
                System.out.println("Already Monster Created");
        }
        System.out.println();
        System.out.println("Final List");
        System.out.println("Monster List");
        monsterSet.stream().forEach(System.out::println);
        System.out.println("Baby Monster List");
        babyMonsterSet.stream().forEach(System.out::println);
    }
}
