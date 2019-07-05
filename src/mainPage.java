import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public mainPage() {
	}

	@Override
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

		String films[] = new String[10];
		for(int i = 0; i<10; i++)
			films[i] = request.getParameter("film"+i);

		ServletOutputStream out = response.getOutputStream();

		String s = readFile("index.html");

		String s1 = "";
		for(int i = 0; i<10; i++)
			if(films[i]!=null)
				s1+="films["+i+"]="+films[i]+"<br>";

		s = s.replaceAll("<!--META_FILMS-->", s1);

		out.println(s);
	}

	@Override
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

	private String readFile(String file){
		try {
			String path = this.getClass().getClassLoader().getResource("").getPath();
			String fullPath = URLDecoder.decode(path, "UTF-8");
			fullPath = fullPath.replace("WEB-INF/classes", "");

			BufferedReader reader = new BufferedReader( new FileReader(fullPath+"WEB/"+file));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			while( ( line = reader.readLine() ) != null ) {
				stringBuilder.append( line );
				stringBuilder.append( ls );
			}

			stringBuilder.deleteCharAt(stringBuilder.length()-1);
			reader.close();
			return stringBuilder.toString();
		}catch(IOException e) {
			e.printStackTrace();
			return "Host error (404)";
		}
	}
}
