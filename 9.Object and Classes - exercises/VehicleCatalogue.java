import java.util.*;

public class VehicleCatalogue {
    static class Vehicle {
        String type;
        String model;
        String color;
        Integer horsePower;

        @Override
        public String toString() {

            return "Type: "+type.substring(0,1).toUpperCase()+type.substring(1)+"\n"+"Model: "+model.substring(0,1).toUpperCase()+model.substring(1)+"\n"+"Color: "+color+"\n"+"Horsepower: "+horsePower;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getModel() {
            return model;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setHorsePower(Integer horsePower) {
            this.horsePower = horsePower;
        }

        public Integer getHorsePower() {
            return horsePower;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> allVehicles = new ArrayList<>();

        double carsHorsePower = 0;
        double trucksHorsePower = 0;
        int carsCounter = 0;
        int trucksCounter = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String type = input.split(" ")[0];
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsePower = Integer.parseInt(input.split(" ")[3]);
            if(type.equals("car")){
                carsHorsePower+=horsePower;
                carsCounter++;
            }
            if(type.equals("truck")){
                trucksHorsePower+=horsePower;
                trucksCounter++;
            }

            Vehicle currentVehicle = new Vehicle();

            currentVehicle.setType(type);
            currentVehicle.setModel(model);
            currentVehicle.setColor(color);
            currentVehicle.setHorsePower(horsePower);

            allVehicles.add(currentVehicle);

            input = scanner.nextLine();


        }
        double averageCarHorsepower;
        double averageTruckHorsepower ;
        if(carsCounter!=0) {
            averageCarHorsepower = carsHorsePower / carsCounter;
        } else {
            averageCarHorsepower=0;
        }
        if(trucksCounter!=0) {
            averageTruckHorsepower = trucksHorsePower / trucksCounter;
        } else {
            averageTruckHorsepower=0;
        }

        input = scanner.nextLine();

        while (!input.equals("Close the Catalogue")){

            for(Vehicle model:allVehicles){
                if(input.equals(model.getModel())){
                    System.out.println(model);
                }
            }
            input = scanner.nextLine();

        }
        System.out.printf("Cars have average horsepower of: %.2f.%n",averageCarHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.",averageTruckHorsepower);

    }
}
