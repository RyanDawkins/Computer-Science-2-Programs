import java.util.ArrayList;

public class Test
{
    public static void main(String[] args)
    {
        Country usa = new Country("USA");

        System.out.println("Created country: "+usa.name());

        State oklahoma = new State(usa, "Oklahoma");
        State texas = new State(usa, "Texas");

        oklahoma.setNeighbor(texas);
        texas.setNeighbor(oklahoma);

        City okc = new City(oklahoma, "OKC");
        oklahoma.setCapital(okc);
        City stillwater = new City(oklahoma, "Stillwater");

        City houston = new City(texas, "Houston");
        City austin = new City(texas, "Austin");

        texas.setCapital(austin);

        State[] states = usa.getStates();
        for(int i = 0; i < states.length; i++)
        {
        	System.out.println("\n--------------------------------");
        	System.out.println("In country "+usa.name()+" there is: "+states[i].name());
        	System.out.println("And "+states[i].capital().name()+" is it's capital.\n");
        	City[] stateCities = states[i].getCities();
        	for(int j = 0; j < stateCities.length; j++)
        	{
        		System.out.println("In state: "+states[i].name()+" there is city: "+stateCities[j].name());
        	}
        }

        River redriver = new River("Red River");
        redriver.setWaterType("Fresh");

        redriver.setBorderPair(oklahoma, texas);

       	ArrayList<Object> objList = redriver.borderOf();
        State[] borderPair = objList.toArray(new State[objList.size()]);

        System.out.print("\n"+redriver.name()+" divides ");
        for(int i = 0; i < borderPair.length; i++)
        {
        	System.out.print(borderPair[i].name());
        	if(i != borderPair.length-1)
        	{
        		System.out.print(", ");
        	}
        }

        System.out.println();

    }
}
