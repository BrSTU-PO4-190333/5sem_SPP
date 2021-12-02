using System;

partial class gpi_Library
{
	public override void gpi_main()
	{
		System.Console.OutputEncoding = System.Text.Encoding.UTF8;
		while (true)
		{
			Console.Clear();
			print_author("Галанин П. И.", "=gpi_main=");

			Console.WriteLine(" Меню:");
			Console.WriteLine(" 1. Меню книги");
			Console.WriteLine(" 2. Меню читателя");
			Console.WriteLine(" Esc. Выйти из программы");

			ConsoleKeyInfo gpi_key = Console.ReadKey();
			string gpi_strKey = Convert.ToString(gpi_key.Key);
			switch (gpi_strKey)
			{
				case "Escape": return;
				case "D1": gpi_printBookMenu(); break;
				case "D2": gpi_printReaderMenu(); break;
				default: break;
			}
		}
	}

	public override void gpi_printBookMenu()
	{
		while (true)
		{
			Console.Clear();
			print_author("Галанин П. И.", "=gpi_printBookMenu=");

			Console.WriteLine(" Меню книг:");
			Console.WriteLine(" 1. Добавить книгу");
			Console.WriteLine(" 2. Печать таблицы книг");
			Console.WriteLine(" 3. Удалить книгу");
			Console.WriteLine(" 4. Редактировать имя книги");
			Console.WriteLine(" Q. Вернуться в главное меню");

			ConsoleKeyInfo gpi_key = Console.ReadKey();
			string gpi_strKey = Convert.ToString(gpi_key.Key);
			switch (gpi_strKey)
			{
				case "D1": gpi_addBook(); break;
				case "D2": gpi_printBookTable(); break;
				case "D3": gpi_deleteBook(); break;
				case "D4": gpi_editBookName(); break;
				case "Q": case "q": return;
				default: break;
			}
		}
	}

	public override void gpi_printReaderMenu()
	{
		while (true)
		{
			Console.Clear();
			print_author("Галанин П. И.", "=gpi_printReaderMenu=");

			Console.WriteLine(" Меню читателя:");
			Console.WriteLine(" 1. Добавить читателя");
			Console.WriteLine(" 2. Печать таблицы читателей");
			Console.WriteLine(" 3. Удалить читателя");
			Console.WriteLine(" 4. Редактировать имя читателя");
			Console.WriteLine(" 5. Редактировать статус читателя");
			Console.WriteLine(" Q. Вернуться в главное меню");

			ConsoleKeyInfo gpi_key = Console.ReadKey();
			string gpi_strKey = Convert.ToString(gpi_key.Key);
			switch (gpi_strKey)
			{
				case "D1": gpi_addReader(); break;
				case "D2": gpi_printReaderTable(); break;
				case "D3": gpi_deleteReader(); break;
				case "D4": gpi_editReaderName(); break;
				case "D5": gpi_editBlackBook(); break;
				case "Q": case "q": return;
				default: break;
			}
		}
	}

	public override void gpi_pressAnyKey()
	{
		Console.WriteLine(" \n Press any key");
		ConsoleKeyInfo gpi_key = Console.ReadKey();
	}

	public override void print_author(string gpi_n1, string gpi_n2)
	{
		Console.WriteLine("\n {0,-16:s} {1:s} \n", gpi_n1, gpi_n2);
	}

}
