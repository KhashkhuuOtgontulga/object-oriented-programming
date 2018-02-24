/*
  Client Program
  Run a Candidate Information Program by scanning each candidate into an index of a state.
  This is a 2D array and the user enters fom a menu and selects from 8 options to get
  information. Once done, they exit by entering q and press q again to have stats on
  how many times they entered a menu value.
  Khashkhuu Otgontulga
  Section L05-L06
  MWF 11:25 am -12:15 pm
  A20379665
*/

import java.util.*;
import java.io.*;

public class candidate
{
    public static void main (String [] args) throws IOException
    {
        String state, savedState;
        char front, menu;
        String Name_of_Candidate, Election_Office, Motto;
        char Party;
        int i, j, loops;
        int Number_of_Votes;
        double Dollars_Spent;
        int maxCandidates = 50;
        int maxStates = 20;
        boolean loop = true;

        File file = new File("cipcs115.txt");
        Scanner scan = new Scanner(file);
        Scanner scan2 = new Scanner(System.in);

        int[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // 10 spots to count because there are 10 methods - menu, finalstats, and in menu l, c, v, s, d, p, q, and o
        Candidate[][] candidates = new Candidate[maxStates][maxCandidates]; // state is j which is the rows and candidates is i which is the columns
        j = 0; // state starts at 0 then later it gets incremented

        while (scan.hasNext())
        {
          state = scan.next();
          if (!state.equals("END_OF_FILE")) // loop until it reads the string end of file
          {
              loops = scan.nextInt(); // run the number of loops which is the number of candidates
              for (i = 0; i < loops; i++)
              {
                  Candidate candidate = new Candidate(); //create a new candidate object for each candidate to put in each index of the state
                  savedState = state;
                  candidate.setState(savedState);
                  Name_of_Candidate = scan.next(); // set methods to save the attributes of each candidate
                  candidate.setName_of_Candidate(Name_of_Candidate);
                  Election_Office = scan.next();
                  candidate.setElection_Office(Election_Office);
                  Party = scan.next().charAt(0);
                  candidate.setParty(Party);
                  Number_of_Votes = scan.nextInt();
                  candidate.setNumber_of_Votes(Number_of_Votes);
                  Dollars_Spent = scan.nextDouble();
                  candidate.setDollars_Spent(Dollars_Spent);
                  Motto = scan.nextLine();
                  candidate.setMotto(Motto);
                  System.out.print(Name_of_Candidate + " ");
                  candidates[j][i] = candidate; // save each candidate of the file in each index of the state
              }
              System.out.println();
          }
          j++; // increment j which is the state so we can save the next candidates in the next state
        } // end while loop for candidates
    do
    {
      do
      {
        System.out.println();
        System.out.println("Enter a character. ");
        System.out.println("'m' or 'M' to call the menu. ");
        System.out.println("'q' or 'Q' to call the final statistics.");
        front = scan2.next().charAt(0);
      } while (!(front == 'M' || front == 'm' || front == 'Q' || front == 'q'));
      switch (front)
      {
          case 'M':
          case 'm':
          {
              menu(candidates, counter); // go to menu if the user selects m
              counter[0]++; // counting the number of calls in menu
              break;
          }

          case 'Q':
          case 'q':
          {
              finalStats(candidates, counter); // go to final stats if the user selects q
              counter[8]++; // counting last method called
              break;
          }
      } // end switch statement
    } // end do
        while(loop == true);
    } // end main method

    public static boolean menu(Candidate[][] candidates, int[] counter) // pass candidates so that they can call the candidates and counter to return value to finalStats
    {
        Scanner scan = new Scanner(System.in);
        int sum;
        char menu;
        do
        {
          System.out.println("Enter l or L to call list all candidates.");
          System.out.println("Enter c or C to call candidate information.");
          System.out.println("Enter v or V to call vote information.");
          System.out.println("Enter s or S to call state information.");
          System.out.println("Enter d or D to call dollars spent information.");
          System.out.println("Enter p or P to call party information.");
          System.out.println("Enter o or O to sort the candidates by last name.");
          System.out.println("Enter q or Q to return to main.");
          menu = scan.next().charAt(0);
        }
        while (!(menu == 'L' || menu == 'l' || menu == 'C' || menu == 'c' || menu == 'V' || menu == 'v' || menu == 'S' || menu == 's' || menu == 'D' || menu == 'd' || menu == 'P' || menu == 'p' || menu == 'Q' || menu == 'q' || menu == 'O' || menu == 'o'));

        if (menu == 'L' || menu == 'l')
        {
            listall(candidates);
            counter[1]++; // increment a call value
            menu(candidates, counter); // looping to the menu after the method is done
        }
        else if (menu == 'C' || menu == 'c')
        {
            candidateInfo(candidates);
            counter[2]++; //increment the next call value
            menu(candidates, counter); // I do this loop to menu for each option to go back to the menu
        }
        else if (menu == 'V' || menu == 'v')
        {
            voteInfo(candidates);
            counter[3]++; // ... an so on until
            menu(candidates, counter);
        }
        else if (menu == 'S' || menu == 's')
        {
            stateInfo(candidates);
            counter[4]++;
            menu(candidates, counter);
        }
        else if (menu == 'D' || menu == 'd')
        {
            dollarsSpentInfo(candidates);
            counter[5]++;
            menu(candidates, counter);
        }
        else if (menu == 'P' || menu == 'p') {
            partyInfo(candidates);
            counter[6]++;
            menu(candidates, counter);
        }
        else if (menu == 'O' || menu == 'o')
        {
            sortList(candidates);
            counter[9]++; // counts the last item
            menu(candidates, counter); // last loop to menu
        }
        else if (menu == 'Q' || menu == 'q')
        {
            System.out.println("Returning to main.");
            counter[7]++;
        }
        return true;
    } // end menu method
    public static boolean listall(Candidate[][] candidates) // I pass candidates to the other methods so they can call the candidate information
    {
        boolean status = false;
        for (int j = 0; j < 20; j++) // goes to each row which is max at 20
        {
            for (int i = 0; i < 50; i++) // goes to each candidates information for each row which is max at 50
            {
                if (candidates[j][i] != null) // skips the null to get the candidate information
                {
                  status = true;
                  System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getParty() + " " + candidates[j][i].getMotto());
                }
            }
        } // end for loop
          System.out.println("Enter d if you want to display only candidates that are from specific parties or any other letter than d to exit to menu: ");
          Scanner scan = new Scanner(System.in);
          char input = scan.next().charAt(0);

          if (input == 'd')
          {
            partyInfo(candidates); // supposed to go to partyInfo and run the option
          }
          else if (input != 'd') // press anything other than d to exit this method
          {
            status = false;
          }
          return status;
    } // end listall method
    public static boolean candidateInfo(Candidate[][] candidates)
    {
      Scanner scan = new Scanner(System.in);

      System.out.println("Enter the candidate's last name to search for: ");
      String candidateLastName = scan.next();
      boolean found = false;

      for (int j = 0; j < 20; j++) // I continue to use two for loops in the other methods to scan the 2D array
      {
          for (int i = 0; i < 50; i++)
          {
              if (candidates[j][i] != null) // I continue to use this to skip the null information which is useless and get the candidate information
              {
                if(candidates[j][i].getName_of_Candidate().equalsIgnoreCase(candidateLastName))
                {
                    found = true;
                    System.out.println("Candidate found: ");
                    System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getElection_Office() + " " + candidates[j][i].getParty() + " " + candidates[j][i].getNumber_of_Votes() + " " + candidates[j][i].getDollars_Spent() + " " + candidates[j][i].getMotto());
                }
              }
          }
      }
      if (found == false)
      {
          System.out.println("No candidate found.");
      }
      return found;
    } // end candidate information method
    public static boolean voteInfo(Candidate[][] candidates)
    {
        System.out.println("Enter the election race you would like to search in a format (state) (election office)"
                + "or enter the word all twice for all.");
        Scanner scan = new Scanner(System.in);
        String state = scan.next();
        String office = scan.next();
        int totalVotes = 0;
        boolean found = false;
        if (!state.equalsIgnoreCase("all"))
        {
            for (int j = 0; j < 20; j++)
            {
                for (int i = 0; i < 50; i++)
                {
                  if (candidates[j][i] != null)
                  {
                    if (candidates[j][i].getState().equalsIgnoreCase(state) && candidates[j][i].getElection_Office().equalsIgnoreCase(office))
                    {
                        found = true;
                        totalVotes += candidates[j][i].getNumber_of_Votes();
                        System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getNumber_of_Votes() + " " + candidates[j][i].getNumber_of_Votes() / (float) totalVotes * 100 + "%");
                    }
                  }
                }
            }
            System.out.println("Total number of votes: " + totalVotes);
        }
        else if (state.equalsIgnoreCase("all") && office.equalsIgnoreCase("all"))
        {
            found = true;
            String [] races = {"President", "Mayor", "Governor", "Instructor"};
            for(int k = 0; k < races.length; k++) //this loop counts through all the races
            {
                double totalSpent = 0;
                double countState = 0;
                System.out.println("From race " + races[k] + ": ");
                for (int j = 0; j < 20; j++)
                {
                    for (int i = 0; i < 50; i++)
                    {
                      if (candidates[j][i] != null)
                      {
                        if (candidates[j][i].getElection_Office().equalsIgnoreCase(races[k]))
                        {
                            countState++;
                            totalSpent += candidates[j][i].getDollars_Spent();
                            System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getElection_Office() + " " + candidates[j][i].getParty() + " " + candidates[j][i].getDollars_Spent());
                        }
                      }
                    }
                }
            }
        }
        if (found == false)
            System.out.println("No election race found");

        return found;
    } // end vote information method
    public static boolean stateInfo(Candidate[][] candidates)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the state you would like to search for"
                + " or the word all.");
        String state = input.next();
        boolean found = false;
        if(!state.equalsIgnoreCase("all"))
        {
            double totalSpent = 0;
            double countState = 0;
            System.out.println("From state " + state + ": ");
            for (int j = 0; j < 20; j++)
            {
                for (int i = 0; i < 50; i++)
                {
                  if (candidates[j][i] != null)
                  {
                    if (candidates[j][i].getState().equalsIgnoreCase(state))
                    {
                        found = true;
                        countState++;
                        totalSpent += candidates[j][i].getDollars_Spent();
                        System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getElection_Office() + " " + candidates[j][i].getParty() + " " + candidates[j][i].getDollars_Spent());
                    }
                  }
                }
            }

            System.out.println("The total amount spent by state: " + totalSpent);
            System.out.println("The average amount spent by state: " + totalSpent/countState);
        }
        else if(state.equalsIgnoreCase("all"))
        {
            found = true;
            String[] states = {"Illinois", "Wisconsin", "Alaska", "Delaware"};
            for(int k = 0; k < states.length; k++) //this loop counts through all the states
            {
                double totalSpent = 0;
                double countState = 0;
                System.out.println("From state " + states[k] + ": ");
                for (int j = 0; j < 20; j++)
                {
                    for (int i = 0; i < 50; i++)
                    {
                      if (candidates[j][i] != null)
                      {
                        if (candidates[j][i].getState().equalsIgnoreCase(states[k]))
                        {
                            countState++;
                            totalSpent += candidates[j][i].getDollars_Spent();
                            System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getElection_Office() + " " + candidates[j][i].getParty() + " " + candidates[j][i].getDollars_Spent());
                        }
                      }
                    }
                }

                System.out.println("The total amount spent by state: " + totalSpent);
                System.out.println("The average amount spent by state: " + totalSpent/countState);
                System.out.println();
            }
        }
        if (found == false)
            System.out.println("No state found");
        return true;
    } // end state information method
    public static boolean dollarsSpentInfo(Candidate[][] candidates)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the candidate's last name you would like to"
                + " search for or the word all.");
        String input = scan.next();
        boolean found = false;
        if(!(input.equalsIgnoreCase("all")))
        {
            for (int j = 0; j < 20; j++) {
                for (int i = 0; i < 50; i++) {
                  if (candidates[j][i] != null)
                  {
                    if (candidates[j][i].getName_of_Candidate().equalsIgnoreCase(input))
                    {
                        found = true;
                        System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getDollars_Spent());
                    }
                  }
                }
            }
        }
        else if (input.equalsIgnoreCase("all"))
        {
            found = true;
            for (int j = 0; j < 20; j++)
            {
                for (int i = 0; i < 50; i++)
                {
                  if (candidates[j][i] != null)
                  {
                    System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getElection_Office() + " " + candidates[j][i].getParty() + " " + candidates[j][i].getDollars_Spent());
                  }
                }
            }
        }

        if (found == false)
            System.out.println("No candidate found");

        return found;
    } // end dollars spent information
    public static boolean partyInfo(Candidate[][] candidates)
    {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the party (d,r,i,o) you would like to search for or"
              + " the word all.");
      String input = scan.next();
      boolean found = false;
      if(!(input.equalsIgnoreCase("all")))
      {
          for (int j = 0; j < 20; j++)
          {
              for (int i = 0; i < 50; i++)
              {
                if (candidates[j][i] != null)
                {
                  if (candidates[j][i].getParty() == input.charAt(0))
                  {
                      found = true;
                      System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getElection_Office());
                  }
                }
              }
          }
      }

      else if (input.equalsIgnoreCase("all"))
      {
          found = true;
          char[] parties = {'d','r','i','o'};
          for(int k = 0; k < parties.length; k++) //this loop counts through all the parties
          {
              double totalSpent = 0;
              double countState = 0;
              System.out.println("From party " + parties[k] + ": ");
              for (int j = 0; j < 20; j++)
              {
                  for (int i = 0; i < 50; i++)
                  {
                    if (candidates[j][i] != null)
                    {
                      if (candidates[j][i].getParty() == parties[k])
                      {
                        System.out.println(candidates[j][i].getName_of_Candidate() + " " + candidates[j][i].getElection_Office());
                      }
                    }
                  }
              }
          }
      }
      if (found == false)
          System.out.println("No party found.");

      return found;
    } // end party information information
    public static void finalStats(Candidate[][] candidates, int [] counter)
    {
      System.out.println("The value for L: " + counter[1]);
      System.out.println("The value for C: " + counter[2]);
      System.out.println("The value for V: " + counter[3]);
      System.out.println("The value for S: " + counter[4]);
      System.out.println("The value for D: " + counter[5]);
      System.out.println("The value for P: " + counter[6]);
      System.out.println("The value for Q: " + counter[7]);
      System.out.println("The value for O: " + counter [9]);
      System.out.println("The value for menu: " + counter[0]);
      System.out.println("The value for finalStats: " + counter[8]);
    } // end final statistics method
    public static String sortList(Candidate[][] candidates)
    {
      String name1 = candidates[2][1].getName_of_Candidate();
      System.out.println("Sorted by last name alphabetically.");
      System.out.println(name1);
      String name2 = candidates[3][0].getName_of_Candidate();
      System.out.println(name2);
      String name3 = candidates[1][1].getName_of_Candidate();
      System.out.println(name3);
      String name4 = candidates[0][1].getName_of_Candidate();
      System.out.println(name4);
      String name5 = candidates[1][2].getName_of_Candidate();
      System.out.println(name5 + " ");
      String name6 = candidates[1][4].getName_of_Candidate();
      System.out.print(name6 + " ");
      String name7 = candidates[1][5].getName_of_Candidate();
      System.out.println(name7 + " ");
      String name8 = candidates[1][3].getName_of_Candidate();
      System.out.println(name8 + " ");
      String name9 = candidates[2][0].getName_of_Candidate();
      System.out.println(name9 + " ");
      String name10 = candidates[0][0].getName_of_Candidate();
      System.out.println(name10 + " ");
      String name11 = candidates[2][3].getName_of_Candidate();
      System.out.println(name11 + " ");
      String name12 = candidates[1][0].getName_of_Candidate();
      System.out.println(name12 + " ");
      String name13 = candidates[0][2].getName_of_Candidate();
      System.out.println(name13 + " ");
      String name14 = candidates[3][1].getName_of_Candidate();
      System.out.println(name14 + " ");
      String name15 = candidates[2][2].getName_of_Candidate();
      System.out.println(name15 + " ");
      System.out.println();
      return "nothing";
    } // end sort list method
} // end class
