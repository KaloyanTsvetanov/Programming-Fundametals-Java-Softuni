import java.util.*;

public class RawData {
    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        Tire[] tires;


        public Tire[] getTires() {
            return tires;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public void setCargo(Cargo cargo) {
            this.cargo = cargo;
        }

        public void setTires(Tire[] tires) {
            this.tires = tires;
        }

        static class Engine {
            Integer engineSpeed;
            Integer enginePower;

            public void setEngineSpeed(Integer engineSpeed) {
                this.engineSpeed = engineSpeed;
            }

            public void setEnginePower(Integer enginePower) {
                this.enginePower = enginePower;
            }
        }

        static class Cargo {
            Integer cargoWeight;
            String cargoType;

            public void setCargoWeight(Integer cargoWeight) {
                this.cargoWeight = cargoWeight;
            }

            public void setCargoType(String cargoType) {
                this.cargoType = cargoType;
            }
        }

        static class Tire {
            Double tirePressure;
            Integer tireAge;

            public void setTireAge(Integer tireAge) {
                this.tireAge = tireAge;
            }

            public Double getTirePressure() {
                return tirePressure;
            }

            public void setTirePressure(Double tirePressure) {
                this.tirePressure = tirePressure;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> allComponents = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0) {

            Car current = new Car();

            String input = scanner.nextLine();

            String model = input.split(" ")[0];

            int engineSpeed = Integer.parseInt(input.split(" ")[1]);

            int enginePower = Integer.parseInt(input.split(" ")[2]);

            int cargoWeight = Integer.parseInt(input.split(" ")[3]);

            String cargoType = input.split(" ")[4];

            Double tirePressure1 = Double.parseDouble(input.split(" ")[5]);
            int tireAge1 = Integer.parseInt(input.split(" ")[6]);

            Double tirePressure2 = Double.parseDouble(input.split(" ")[7]);
            int tireAge2 = Integer.parseInt(input.split(" ")[8]);

            Double tirePressure3 = Double.parseDouble(input.split(" ")[9]);
            int tireAge3 = Integer.parseInt(input.split(" ")[10]);

            Double tirePressure4 = Double.parseDouble(input.split(" ")[11]);
            int tireAge4 = Integer.parseInt(input.split(" ")[12]);

            //SET MODEL
            current.setModel(model);

            //SET ENGINE
            Car.Engine currentEngine = new Car.Engine();
            currentEngine.setEngineSpeed(engineSpeed);
            currentEngine.setEnginePower(enginePower);
            current.setEngine(currentEngine);

            //SET CARGO
            Car.Cargo currentCargo = new Car.Cargo();
            currentCargo.setCargoWeight(cargoWeight);
            currentCargo.setCargoType(cargoType);
            current.setCargo(currentCargo);

            //SET TIRES
            Car.Tire firstTire = new Car.Tire();
            Car.Tire secondTire = new Car.Tire();
            Car.Tire thirdTire = new Car.Tire();
            Car.Tire fourthTire = new Car.Tire();

            firstTire.setTirePressure(tirePressure1);
            firstTire.setTireAge(tireAge1);
            secondTire.setTirePressure(tirePressure2);
            secondTire.setTireAge(tireAge2);
            thirdTire.setTirePressure(tirePressure3);
            thirdTire.setTireAge(tireAge3);
            fourthTire.setTirePressure(tirePressure4);
            fourthTire.setTireAge(tireAge4);
            Car.Tire[] currentTire = {firstTire, secondTire, thirdTire, fourthTire};
            current.setTires(currentTire);

            allComponents.add(current);


            n--;
        }
        String input = scanner.nextLine();
        if(input.equals("fragile")){
            for(Car type : allComponents){
                boolean print = false;
                Car.Tire [] pr = type.getTires();
                for (int i = 0; i < pr.length-1; i++) {
                    Double pressure = pr[i].getTirePressure();
                    if(pressure<1){
                        print = true;
                    }
                }
                if(print){
                    System.out.println(type.model);
                }
            }


        }else if(input.equals("flamable")){

            for(Car engine : allComponents){
                if(engine.engine.enginePower>250){
                    System.out.println(engine.model);
                }
            }
        }
    }
}
