#JHTP - An simple to use java HTML to PDF converter.

It works by converting an HTML to an XSL-FO, then uses Apache FOP to convert the XSL-FO to the final PDF.

The converter try, to maximum possible extent in the XSL-FO capabilities, create the most similar PDF to the HTML viewed in a browser.

** This converter doesn't have full HTML and CSS support, it's intended to fastly convert an simple, multipage PDF reports **

** The basic usage is very simple:

```
HtmlToPdf converter = new HtmlToPdf("<p>Hello World!</p>");
converter.convertToFile(new File("out/output.pdf"));

```