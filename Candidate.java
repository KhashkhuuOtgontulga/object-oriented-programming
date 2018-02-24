/*
 Service Class
 Khashkhuu Otgontulga
 Section L05-L06
 A20379665
 */
public class Candidate
{
    private String State;
    private String Name_of_Candidate;
    private String Election_Office;
    private char Party;
    private int Number_of_Votes;
    private double Dollars_Spent;
    private String Motto;

    public Candidate()
    {
      State = "noState";
      Name_of_Candidate = "NoName";
      Election_Office = "NoOffice";
      Party = 'n';
      Number_of_Votes = 0;
      Dollars_Spent = 0.0;
      Motto = "Nothing";
    }

    public String getState()
    {
        return State;
    }
    public String getName_of_Candidate()
    {
        return Name_of_Candidate;
    }
    public String getElection_Office()
    {
        return Election_Office;
    }
    public char getParty()
    {
        return Party;
    }
    public int getNumber_of_Votes()
    {
        return Number_of_Votes;
    }
    public double getDollars_Spent()
    {
        return Dollars_Spent;
    }
    public String getMotto()
    {
        return Motto;
    }
    // all getter methods

    public void setState(String newState)
    {
      if (newState == "Illinois")
      {
          State = newState;
      }
      else if (newState == "Wisconsin")
      {
          State = newState;
      }
      else if (newState == "Alaska")
      {
          State = newState;
      }
      else
      {
          State = newState;
      }
    }
    public void setName_of_Candidate(String newName_of_Candidate)
    {
        Name_of_Candidate = newName_of_Candidate;
    }
    public void setElection_Office(String newElection_Office)
    {
        Election_Office = newElection_Office;
    }
    public void setParty(char newParty)
    {
        if (newParty == 'd')
        {
            Party = newParty;
        }
        else if (newParty == 'r')
        {
            Party = newParty;
        }
        else if (newParty == 'i')
        {
            Party = newParty;
        }
        else
        {
            Party = 'o';
        }
    }
    public int setNumber_of_Votes(int newNumber_of_Votes)
    {
        if (newNumber_of_Votes > 0)
        {
            Number_of_Votes = newNumber_of_Votes;
        }
        return Number_of_Votes;
    }
    public boolean setDollars_Spent(double newDollars_Spent)
    {
        if (newDollars_Spent > 0)
        {
            Dollars_Spent = newDollars_Spent;
        }
        return true;
    }

    public void setMotto(String newMotto)
    {
        Motto = newMotto;
    }
    // all setter methods
    public void display()
    {
        System.out.print(Name_of_Candidate + " " + Election_Office + " " + Party + " " + Number_of_Votes + " " + Dollars_Spent + " " + Motto);
    }
    public String toString()
    {
        return (Name_of_Candidate + " " + Election_Office + " " + Party + " " + Number_of_Votes + " " + Dollars_Spent + " " + Motto);
    }
    public boolean equals(Candidate object)
    {
        if (Name_of_Candidate == Name_of_Candidate)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
