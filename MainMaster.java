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
        System.out.println("Enter the n Monsters : ");

        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Monster : "+(i+1));
            String s1 = sc.next();
            String s2 = sc.next();

            boolean s3 = sc.nextBoolean();
            int s4 = sc.nextInt();
            int s5 = sc.nextInt();
            int s6 = sc.nextInt();
            int s7 = sc.nextInt();

            Monster monster = new Monster(s1,s2,s3,s4,s5,s6,s7);

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
                    System.out.println("Baby Monster List After Monster "+(i+1)+" Added");
                    babyMonsterSet.stream().forEach(System.out::println);
                }

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
