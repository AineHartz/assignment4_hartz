import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Assignment_Code 
{
	public static void main(String args[])
	{
		//System.out.println(isBalanced("{[()]}"));
		//System.out.println(isBalanced("{[(])}"));
		//System.out.println(isBalanced("{{[[(())]]}}"));
		
		//dna_to_rna("AGCTGGGAAACGTAGGCCTA");
		//dna_to_rna("TTTTTTTTTTGGCGCG");
		//dna_to_rna("CTTTGGGACTAGTAACCCATTTCGGCT");
		
		//proteins("AGCUGGGAAACGUAGGCCUA");
		/*
		 * Everything I can find points to the sample answer being wrong. I went through the sequence and
		 * translated it manually, I found another graph to translate with, I translated it with my code as 
		 * a guide, I translated it using a few rna to protein convertors online, everything says the answer
		 * to this is .REAS, with the only source disagreeing being the sample answer. 
		 */
		//proteins("UAAAGAGAAGCCAGC");
		
		System.out.println(infix_to_postfix("a+b*(c^d-e)^(f+g*h)-i"));
	}
	
	public static String isBalanced(String s)
	{
		Stack stack = new Stack();
		
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(' )
			{
				stack.push(s.charAt(i));
			}
			
			else if(s.charAt(i) == ')')
			{
				if((char) stack.pop() != '(')
				{
					return "no";
				}
			}
			
			else if(s.charAt(i) == ']')
			{
				if((char) stack.pop() != '[')
				{
					return "no";
				}
			}
			
			else if(s.charAt(i) == '}')
			{
				if((char) stack.pop() != '{')
				{
					return "no";
				}
			}
		}
		
		
		return "yes";
	}
	
	public static String dna_to_rna(String s)
	{	
		String output = "";
		Queue queue = new LinkedList();
		
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == 'T')
			{
				queue.add('U');
			}
			
			else
			{
				queue.add(s.charAt(i));
			}
		}
		
		while(queue.isEmpty() == false)
		{
			output += queue.remove();
		}
		
		System.out.println(output);
		return output;
	}
	
	public static String proteins(String s)
	{
		String output = "";
		String temp = "";
		int three = 0;
		
		for(int i = 0; i < s.length(); i++)
		{
			temp += s.charAt(i);
			three++;
			
			if(three == 3)
			{
				//The code for converting was extremly ugly, so I banished it to it's own method
				//to keep this one pretty. See convert method below. 
				output += convert(temp);
				temp = "";
				three = 0;
			}
			
			if(three != 3 && (i == (s.length() - 1)))
			{
				output += '.';
			}
		}
		
		System.out.println(output);
		return output;
	}
	
	public static String convert(String s)
	{
		String output = "";
		Queue queue = new LinkedList();
		queue.add(s.charAt(0));
		queue.add(s.charAt(1));
		queue.add(s.charAt(2));

		char check = (char) queue.remove();
		
		if(check == 'U')
		{
			check = (char) queue.remove();

			if(check == 'U')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'F';
				}
			
				else if (check == 'C')
				{
					output += 'F';
				}
				
				else if (check == 'A')
				{
					output += 'L';
				}
				
				else if(check == 'G')
				{
					output += 'L';
				}
			}
			
			else if (check == 'C')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'S';
				}
				
				else if (check == 'C')
				{
					output += 'S';
				}
				
				else if (check == 'A')
				{
					output += 'S';
				}
				
				else if(check == 'G')
				{
					output += 'S';
				}
			}
			
			else if (check == 'A')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'Y';
				}
				
				else if (check == 'C')
				{
					output += 'Y';
				}
				
				else if (check == 'A')
				{
					output += '.';
				}
				
				else if(check == 'G')
				{
					output += '.';
				}
			}
			
			else if(check == 'G')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'C';
				}
				
				else if (check == 'C')
				{
					output += 'C';
				}
				
				else if (check == 'A')
				{
					output += '.';
				}
				
				else if(check == 'G')
				{
					output += 'W';
				}
			}
		}
		
		else if (check == 'C')
		{
			check = (char) queue.remove();
			
			if(check == 'U')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'L';
				}
				
				else if (check == 'C')
				{
					output += 'L';
				}
				
				else if (check == 'A')
				{
					output += 'L';
				}
				
				else if(check == 'G')
				{
					output += 'L';
				}
			}
			
			else if (check == 'C')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'P';
				}
				
				else if (check == 'C')
				{
					output += 'P';
				}
				
				else if (check == 'A')
				{
					output += 'P';
				}
				
				else if(check == 'G')
				{
					output += 'P';
				}
			}
			
			else if (check == 'A')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'H';
				}
				
				else if (check == 'C')
				{
					output += 'H';
				}
				
				else if (check == 'A')
				{
					output += 'Q';
				}
				
				else if(check == 'G')
				{
					output += 'Q';
				}
			}
			
			else if(check == 'G')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'R';
				}
				
				else if (check == 'C')
				{
					output += 'R';
				}
				
				else if (check == 'A')
				{
					output += 'R';
				}
				
				else if(check == 'G')
				{
					output += 'R';
				}
			}
		}
		
		else if (check == 'A')
		{
			check = (char) queue.remove();
			
			if(check == 'U')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'I';
				}
				
				else if (check == 'C')
				{
					output += 'I';
				}
				
				else if (check == 'A')
				{
					output += 'I';
				}
				
				else if(check == 'G')
				{
					output += 'M';
				}
			}
			
			else if (check == 'C')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'T';
				}
				
				else if (check == 'C')
				{
					output += 'T';
				}
				
				else if (check == 'A')
				{
					output += 'T';
				}
				
				else if(check == 'G')
				{
					output += 'T';
				}
			}
			
			else if (check == 'A')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'N';
				}
				
				else if (check == 'C')
				{
					output += 'N';
				}
				
				else if (check == 'A')
				{
					output += 'K';
				}
				
				else if(check == 'G')
				{
					output += 'K';
				}
			}
			
			else if(check == 'G')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'S';
				}
				
				else if (check == 'C')
				{
					output += 'S';
				}
				
				else if (check == 'A')
				{
					output += 'R';
				}
				
				else if(check == 'G')
				{
					output += 'R';
				}
			}
		}
		
		else if(check == 'G')
		{
			check = (char) queue.remove();
			
			if(check == 'U')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'V';
				}
				
				else if (check == 'C')
				{					
					output += 'V';
				}
				
				else if (check == 'A')
				{
					output += 'V';
				}
				
				else if(check == 'G')
				{
					output += 'V';
				}
			}
			
			else if (check == 'C')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'A';
				}
				
				else if (check == 'C')
				{
					output += 'A';
				}
				
				else if (check == 'A')
				{
					output += 'A';
				}
				
				else if(check == 'G')
				{
					output += 'A';
				}
			}
			
			else if (check == 'A')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'D';
				}
				
				else if (check == 'C')
				{
					output += 'D';
				}
				
				else if (check == 'A')
				{
					output += 'E';
				}
				
				else if(check == 'G')
				{
					output += 'E';
				}
			}
			
			else if(check == 'G')
			{
				check = (char) queue.remove();
				
				if(check == 'U')
				{
					output += 'G';
				}
				
				else if (check == 'C')
				{
					output += 'G';
				}
				
				else if (check == 'A')
				{
					output += 'G';
				}
				
				else if(check == 'G')
				{
					output += 'G';
				}
			}
		}
		
		return output;
	}
	
	public static String infix_to_postfix(String s)
	{
		Stack stack = new Stack();
		String output = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '(')
			{
				stack.push(s.charAt(i));
			}
			
			
			else if(s.charAt(i) == ')')
			{
				while(stack.isEmpty() == false && (char) stack.peek() != '(')
				{
					output += stack.pop();
				}
				
				stack.pop();
			}
			
			else if(s.charAt(i) == '^' || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+' || s.charAt(i) == '-')
			{
				while(stack.isEmpty() == false && precedence_table((char) stack.peek()) >= precedence_table(s.charAt(i)))
				{
					output += stack.pop();
				}
				
				stack.push(s.charAt(i));
			}
			
			else
			{
				output += s.charAt(i);
			}
		}
		
		while(stack.isEmpty() == false)
		{
			output += stack.pop();
		}
		
		return output;
	}
	
	//This method governs the precendence for operators for infix to postfix.
	public static int precedence_table(char c)
	{
		if(c == '^')
		{
			return 3;
		}
		
		else if(c == '*' || c == '/')
		{
			return 2;
		}
		
		else if(c == '+' || c == '-')
		{
			return 1;
		}
		
		else
		{
			return 0;
		}
	}
}
