using System;
using System.Collections.Generic;

partial class gpi_LibraryReader
{
	public List<gpi_Book> gpi_books = new List<gpi_Book>();

	public class gpi_Book
	{
		public String gpi_bookName;
		public String gpi_readerName;

		public gpi_Book(string gpi_bookName)
		{
			this.gpi_bookName = gpi_bookName;
			this.gpi_readerName = "";
		}
	}

	public void gpi_addBook()
	{
		Console.Clear();
		print_author("Галанин П. И.", "=gpi_addBook=");

		Console.Write(" gpi_bookName ");
		string gpi_bookName = Console.ReadLine();
		this.gpi_books.Add(new gpi_Book(gpi_bookName));

		Console.WriteLine(" Добавлена новая книга");
		gpi_pressAnyKey();
	}

	public void gpi_printBookTable()
	{
		Console.Clear();
		print_author("Галанин П. И.", "=gpi_printBookTable=");

		int gpi_length = this.gpi_books.Count;

		if (gpi_length == 0)
        {
			Console.WriteLine(" Нет данных");
			gpi_pressAnyKey();
			return;

		}

		int gpi_i = 0;
		Console.WriteLine(" | {0,-8:s} | {1,-48:s} | {2,-48:s} |",
			"#",
			"Имя книги",
			"Имя читателя"
			);
		Console.WriteLine(" | {0,-8:s} | {1,-48:s} | {2,-48:s} |",
			"--------",
			"------------------------------------------------",
			"------------------------------------------------"
			);
		while (gpi_i < gpi_length)
		{
			Console.WriteLine(" | {0,-8:d} | {1,-48:s} | {2,-48:s} |",
				gpi_i,
				this.gpi_books[gpi_i].gpi_bookName,
				this.gpi_books[gpi_i].gpi_readerName
				);
			++gpi_i;
		}

		gpi_pressAnyKey();
	}

	public void gpi_deleteBook()
	{
		Console.Clear();
		print_author("Галанин П. И.", "=gpi_deleteBook=");

		int gpi_length = this.gpi_books.Count;
		if (gpi_length == 0)
		{
			Console.WriteLine(" Нет элементов для удаления");
			gpi_pressAnyKey();
			return;
		}

		try
		{
			Console.Write(" gpi_id ");
			int gpi_id = Convert.ToInt32(Console.ReadLine());
			this.gpi_books.RemoveAt(gpi_id);
			Console.WriteLine(" Книга удалена успешно");
			gpi_pressAnyKey();
		}
		catch (System.FormatException)
		{
			gpi_deleteBook();
			return;
		}
		catch (System.ArgumentOutOfRangeException)
		{
			Console.WriteLine(" Нет такого элемента под таким gpi_id");
			gpi_pressAnyKey();
		}
	}

	public void gpi_editBookName()
	{
		Console.Clear();
		print_author("Галанин П. И.", "=gpi_editBookName=");

		int gpi_length = this.gpi_books.Count;
		if (gpi_length == 0)
		{
			Console.WriteLine(" Нет элементов для изменения");
			gpi_pressAnyKey();
			return;
		}

		try
		{
			Console.Write(" gpi_id ");
			int gpi_id = Convert.ToInt32(Console.ReadLine());
			while (gpi_id < 0 || gpi_id >= gpi_length)
			{
				Console.Write(" gpi_id ");
				gpi_id = Convert.ToInt32(Console.ReadLine());
			}

			Console.Write(" gpi_bookName ");
			string gpi_bookName = Console.ReadLine();
			this.gpi_books[gpi_id].gpi_bookName = gpi_bookName;

			Console.WriteLine(" Имя книги изменено успешно");
			gpi_pressAnyKey();
		}
		catch (System.FormatException)
		{
			gpi_editBookName();
		}
		catch (System.ArgumentOutOfRangeException)
		{
			gpi_editBookName();
		}
	}
}
