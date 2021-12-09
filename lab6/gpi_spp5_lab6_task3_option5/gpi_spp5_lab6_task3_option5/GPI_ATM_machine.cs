using System;

public class GPI_ATM_machine
{
	private GPI_CardData[]		gpi_data			= {
        new GPI_CardData(1111222233334444,10.15),
		new GPI_CardData(1111222233334445,0.05),
		new GPI_CardData(1111222233334446,156.22),
		new GPI_CardData(1111222233334447,967.32),
		new GPI_CardData(1111222233334448,235.60),
		new GPI_CardData(1111222233334449,0.01)
	};
	private int					gpi_id;
	private long				gpi_card_number		= 0;
	private double				gpi_balance;
	private bool				gpi_is_valid		= false;
	private ConsoleKeyInfo		gpi_key;
	private string				gpi_strKey;

	public GPI_ATM_machine()
	{
		while (true)
        {
			if (gpi_is_valid == false)
            {
				gpi_insert_card();
				continue;
			}

			if (gpi_is_valid == true)
            {
				gpi_menu();
				continue;
			}
		}
	}

	public void gpi_insert_card()
    {
		Console.Clear();
		Console.WriteLine(" =gpi_insert_card= \n");

		Console.Write(" gpi_insert_card Insert your card: ");
		try
        {
			gpi_card_number = long.Parse(Console.ReadLine());
		}
		catch (System.FormatException)
        {
			gpi_insert_card();
			return;
        }
		
		for (int gpi_i = 0; gpi_i < gpi_data.Length; ++gpi_i)
        {
			if (gpi_data[gpi_i].GPI_get_gpi_card_number() == gpi_card_number)
            {
				gpi_is_valid = true;
				gpi_id = gpi_i;
				break;
			}
        }		
		
		if (gpi_is_valid == false)
        {
			return;
        }

		if (gpi_is_valid == true)
        {
			Console.WriteLine(" gpi_insert_card The card is pressed \n");
			return;
		}
	}

	public void gpi_menu()
    {
		while(true)
        {
			Console.Clear();
			Console.WriteLine(" =gpi_menu= \n");

			Console.WriteLine(" 1. Checking the balance");
			Console.WriteLine(" 2. Withdraw in cash");
			Console.WriteLine(" 3. Top up your card");
			Console.WriteLine(" Esc. Return the card \n");

			gpi_key = Console.ReadKey();
			gpi_strKey = Convert.ToString(gpi_key.Key);

			if (gpi_strKey == "D1")
			{
				gpi_print_balance();
				continue;
			}

			if (gpi_strKey == "D2")
			{
				gpi_withdraw_in_cash();
				continue;
			}

			if (gpi_strKey == "D3")
			{
				gpi_top_up_card();
				continue;
			}

			if (gpi_strKey == "Escape")
            {
				gpi_is_valid = false;
				Console.WriteLine(" gpi_menu Take your card");
				break;
			}
		}
    }

	public void gpi_print_balance()
    {
		Console.Clear();
		Console.WriteLine(" =gpi_print_balance= \n");

		gpi_balance = gpi_data[gpi_id].GPI_get_gpi_sum();
		Console.WriteLine(" gpi_print_balance " + gpi_balance);

		Console.WriteLine(" \n gpi_print_balance Press the key to return to the menu");
		gpi_key = Console.ReadKey();
		gpi_strKey = Convert.ToString(gpi_key.Key);
	}

	public void gpi_top_up_card()
    {
		while (true)
        {
			Console.Clear();
			Console.WriteLine(" =gpi_top_up_card= \n");

			Console.WriteLine(" 1. Add 5 BYN");
			Console.WriteLine(" 2. Add 10 BYN");
			Console.WriteLine(" 3. Add 20 BYN");
			Console.WriteLine(" 4. Add 50 BYN");
			Console.WriteLine(" Esc. Go back to the menu \n");

			gpi_key = Console.ReadKey();
			gpi_strKey = Convert.ToString(gpi_key.Key);

			if (gpi_strKey == "D1")
			{
				gpi_data[gpi_id].GPI_add_sum_5();
				continue;
			}

			if (gpi_strKey == "D2")
			{
				gpi_data[gpi_id].GPI_add_sum_10();
				continue;
			}

			if (gpi_strKey == "D3")
			{
				gpi_data[gpi_id].GPI_add_sum_20();
				continue;
			}

			if (gpi_strKey == "D4")
			{
				gpi_data[gpi_id].GPI_add_sum_50();
				continue;
			}

			if (gpi_strKey == "Escape")
			{
				break;
			}
		}
    }

	public void gpi_withdraw_in_cash()
    {
		while(true)
        {
			Console.Clear();
			Console.WriteLine(" =gpi_withdraw_in_cash= \n");

			Console.WriteLine(" 1. Withdraw 5 BYN");
			Console.WriteLine(" 2. Withdraw 10 BYN");
			Console.WriteLine(" 3. Withdraw 20 BYN");
			Console.WriteLine(" 4. Withdraw 50 BYN");
			Console.WriteLine(" Esc. Go back to the menu \n");

			gpi_key = Console.ReadKey();
			gpi_strKey = Convert.ToString(gpi_key.Key);

			if (gpi_strKey == "D1")
			{
				bool gpi_result = gpi_data[gpi_id].GPI_withdraw_sum_5();

				if (gpi_result == false)
				{
					Console.WriteLine(" \n gpi_withdraw_in_cash Not enough money on the balance sheet");
					gpi_key = Console.ReadKey();
					gpi_strKey = Convert.ToString(gpi_key.Key);
					continue;
				}
			}

			if (gpi_strKey == "D2")
			{
				bool gpi_result = gpi_data[gpi_id].GPI_withdraw_sum_10();

				if (gpi_result == false)
				{
					Console.WriteLine(" \n gpi_withdraw_in_cash Not enough money on the balance sheet");
					gpi_key = Console.ReadKey();
					gpi_strKey = Convert.ToString(gpi_key.Key);
					continue;
				}
			}

			if (gpi_strKey == "D3")
			{
				bool gpi_result = gpi_data[gpi_id].GPI_withdraw_sum_20();

				if (gpi_result == false)
				{
					Console.WriteLine(" \n gpi_withdraw_in_cash Not enough money on the balance sheet");
					gpi_key = Console.ReadKey();
					gpi_strKey = Convert.ToString(gpi_key.Key);
					continue;
				}
			}

			if (gpi_strKey == "D4")
			{
				bool gpi_result = gpi_data[gpi_id].GPI_withdraw_sum_50();

				if (gpi_result == false)
				{
					Console.WriteLine(" \n gpi_withdraw_in_cash Not enough money on the balance sheet");
					gpi_key = Console.ReadKey();
					gpi_strKey = Convert.ToString(gpi_key.Key);
					continue;
				}
			}

			if (gpi_strKey == "Escape")
			{
				break;
			}
		}
    }
}
