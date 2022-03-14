import java.io.*;

public class PointSaver {
    ByteArrayOutputStream bos;
    DataOutputStream dos;
    RandomAccessFile DataFile;

    public PointSaver() throws IOException {
        this.bos= new ByteArrayOutputStream(PointDataPage.DataPageSize);
        this.dos= new DataOutputStream(bos);

        File newFile= new File("Point_Data.txt");
        this.DataFile = new RandomAccessFile("Point_Data", "rw");
        //this.FileToSaveData.seek(-1);
    }

    /**
     * Save an array of points
     * @param pointArray The array of points to save
     * @throws IOException
     */
    public void saveArrayOfPoints(Point[] pointArray) throws IOException {
        DataFile.seek(0);
        bos.reset();
        byte[] buffer; //Buffer array used to store data

        for(int i= 0; i< pointArray.length; i++) {
            if(pointArray[i]!= null) {
                dos.writeInt(pointArray[i].getX()); //Write x value to bos
                dos.writeInt(pointArray[i].getY()); //Write y value to bos

                System.out.println("Buffer size: "+ dos.size());
                System.out.println("Byte Buffer size: "+ bos.size());

                if(bos.size()== PointDataPage.DataPageSize) { //If bos is full then write its data in the file
                    buffer= bos.toByteArray();   //Turn bos to byte array
                    this.DataFile.write(buffer);  //Write data to file
                    bos.reset();
                }
            }
        }
        buffer= bos.toByteArray();   //Turn bos to byte array
        this.DataFile.write(buffer);
        System.out.println("Data successfully saved");
    }

    /**
     * Load data from the file to an array of points and return it
     * @return An array of points with the loaded data
     * @throws IOException
     */
    public Point[] loadPointsToPointList(File dataFile) throws IOException {
        RandomAccessFile file= new RandomAccessFile(dataFile.getPath(), "r");
        file.seek(0); //Start reading from the beginning

        byte[] buffer= new byte[PointDataPage.DataPageSize]; //Buffer used for reading the data of the file
        int maxIntegersPerBuff= buffer.length/4; //Maximum integers that can be read from one full buffer

        int j= 0;
        ByteArrayInputStream bis= new ByteArrayInputStream(buffer);
        DataInputStream dis= new DataInputStream(bis);

        while(DataFile.read(buffer)!= -1) {
            for(int i= 0; i< maxIntegersPerBuff; i++) {
                int temporary= dis.readInt();
                System.out.println("Read int: "+temporary);
                j++;
                System.out.println(j);
            }
            bis.reset();
            dis.reset();
        }
        return new Point[10];
    }

    /**
     * Load data from the file to an array of points and return it
     * @return An array of points with the loaded data
     * @throws IOException
     */
    public PointList loadPointsToPointList(RandomAccessFile dataFile) throws IOException {
        dataFile.seek(0); //Start reading from the beginning

        byte[] buffer= new byte[PointDataPage.DataPageSize]; //Buffer used for reading the data of the file
        int maxIntegersPerBuff= buffer.length/4; //Maximum integers that can be read from one full buffer

        PointList listToReturn= new PointList();
        int j= 0;
        ByteArrayInputStream bis= new ByteArrayInputStream(buffer);
        DataInputStream dis= new DataInputStream(bis);

        while(DataFile.read(buffer)!= -1) {
            for(int i= 0; i< maxIntegersPerBuff; i++) {
                int x= dis.readInt();
                int y= dis.readInt();

                listToReturn.insert(new Point(x, y));
            }
            bis.reset();
            dis.reset();
        }
        System.out.println(listToReturn.getNumberOfEntries());
        return listToReturn;
    }
}
