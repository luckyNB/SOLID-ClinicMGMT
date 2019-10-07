package com.openclose.main;

import com.ims.util.Utility;
import com.openclose.model.Car;
import com.openclose.model.ElectrnicDevice;
import com.openclose.model.Food;
import com.openclose.model.Gem;

public class MainClass {

	public static void main(String[] args) {
		int choice = 0;

		do {
			System.out.println("***************Shopping Cart Service******************");
			System.out.println("1. for getting tax CAR                      |");
			System.out.println("2. for getting tax FOOD                     |");
			System.out.println("3. for getting tax GEM                      |");
			System.out.println("5. for getting tax Electronic Device        |");
			System.out.println("6. For Exit the shopping cart service       |");
			System.out.println("____________________________________________|");
			choice = Utility.inputInteger("Enter your choice");

			switch (choice) {
			case 1:
				Car car = new Car();
				car.setBasePrice(Utility.inputDouble("Enter Base Price"));
				System.out.println(car.calculateTaxIncludedPrice());
				break;

			case 2:
				Food food = new Food();
				food.setBasePrice(Utility.inputDouble("Enter Base Price"));
				System.out.println(food.calculateTaxIncludedPrice());
				break;

			case 3:
				Gem gem = new Gem();
				gem.setBasePrice(Utility.inputDouble("Enter Base Price"));
				System.out.println(gem.calculateTaxIncludedPrice());
				break;

			case 4:
				ElectrnicDevice device = new ElectrnicDevice();
				device.setBasePrice(Utility.inputDouble("Enter Base Price"));
				System.out.println(device.calculateTaxIncludedPrice());
				break;

			default:
				System.out.println("You have entered wrong Choice");
				
				break;
			}

		} while (choice < 5);

	}
}
