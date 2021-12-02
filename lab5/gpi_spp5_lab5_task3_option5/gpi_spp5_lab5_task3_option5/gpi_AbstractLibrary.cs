using System;
using System.Collections.Generic;

public abstract class gpi_AbstractLibrary
{
	// = = = = = = = = = = = = menus = = = = = = = = = = = =

	public abstract void gpi_main();
	public abstract void gpi_printBookMenu();
	public abstract void gpi_printReaderMenu();
	public abstract void gpi_pressAnyKey();
	public abstract void print_author(string gpi_n1, string gpi_n2);

	// = = = = = = = = = = = = books = = = = = = = = = = = =

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

	public abstract void gpi_addBook();
	public abstract void gpi_printBookTable();
	public abstract void gpi_deleteBook();
	public abstract void gpi_editBookName();

	// = = = = = = = = = = = = readers = = = = = = = = = = = =

	public List<gpi_Reader> gpi_readers = new List<gpi_Reader>();

	public class gpi_Reader
	{
		public String gpi_readerName;
		public Boolean gpi_blackBook;

		public gpi_Reader(string gpi_readerName)
		{
			this.gpi_readerName = gpi_readerName;
			this.gpi_blackBook = false;
		}
	}

	public abstract void gpi_editBlackBook();
	public abstract void gpi_addReader();
	public abstract void gpi_printReaderTable();
	public abstract void gpi_deleteReader();
	public abstract void gpi_editReaderName();
}
