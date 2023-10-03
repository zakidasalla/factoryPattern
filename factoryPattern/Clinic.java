package factoryPattern;

import java.util.Scanner;

public class Clinic {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        boolean toEnd = false;
        while(!toEnd){
            System.out.println("[1] Dog");
            System.out.println("[2] Cat");
            System.out.println("[3] Exit");
            System.out.print("\nChoose an option: ");
            Integer choice = input.nextInt();

            PetRecord petFile = new PetRecord();
            Pet pet;

            switch(choice){
                case 1:
                    pet = new Dog();
                    petFile.setPetId("D01");
                    petFile.setPetName("Bantay");
                    petFile.setPet(pet);
                    ((Dog) pet).setBreed("German Shepperd");
                    printPetInfo(petFile,pet);
                    break;
                case 2:
                    pet = new Cat();
                    petFile.setPetId("C01");
                    petFile.setPetName("Muning");
                    petFile.setPet(pet);
                    ((Cat) pet).setNoOfLives(9);
                    printPetInfo(petFile,pet);
                    break;
                case 3:
                    toEnd = true;
                    break;
                default:
                    continue;
            }
        }
    }

    public static void printPetInfo(PetRecord petFile, Pet pet){
        System.out.println("Pet id is " + petFile.getPetId());
        System.out.println("Pet name is " + petFile.getPetName());
        System.out.println("Pet kind: " + petFile.getPet().getClass().getSimpleName());
        System.out.println("Communication sound: "+ petFile.getPet().makeSound());
        System.out.println("Play mode: " + petFile.getPet().play());

        if (pet instanceof Dog) {
            System.out.println("Breed: " + ((Dog) pet).getBreed());
        } else if (pet instanceof Cat) {
            System.out.println("Number of lives: " + ((Cat) pet).getNoOfLives());
        }
        System.out.println();
    }
}
