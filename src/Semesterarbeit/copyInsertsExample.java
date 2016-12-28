public class copyInsertsExample() {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    CopyManager cpManager = ((PGConnection)conn).getCopyAPI();
    PushbackReader reader = new PushbackReader( new StringReader(""), 10000 );
    for (int i=0; i<testSize; i++)
    {
        sb.append(measurementIds[i]).append(",'")
          .append(timestamps[i]).append("',")
          .append(values[i]).append("\n");
        if (i % batchSize == 0)
        {
          reader.unread( sb.toString().toCharArray() );
          cpManager.copyIn("COPY measurement FROM STDIN WITH CSV", reader );
          sb.delete(0,sb.length());
        }
    }
    reader.unread( sb.toString().toCharArray() );
    cpManager.copyIn("COPY measurement FROM STDIN WITH CSV", reader );
  }
}
