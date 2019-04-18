 import mpi.MPI;

    public class ScatterGather {
   	 public static void main(String args[]){
	//Initialize MPI execution environment
   	 MPI.Init(args);
	//Get the id of the process
   	 int rank = MPI.COMM_WORLD.Rank();
	//total number of processes is stored in size
   	 int size = MPI.COMM_WORLD.Size();
   	 int root=0;
	//array which will be filled with data by root process
   	 double sendbuf[]=null;

   	 sendbuf= new double[size];

	//creates data to be scattered
   	 if(rank==root){
   		 sendbuf[0] = 10;
   		 sendbuf[1] = 20;
   		 sendbuf[2] = 30;
   		 sendbuf[3] = 40;

		//print current process number
   		 System.out.print("Processor "+rank+" has data: ");
   		 for(int i = 0; i < size; i++){
   			 System.out.print(sendbuf[i]+" ");
   		 }
   		 System.out.println();
   	 }
	//collect data in recvbuf
   	 double recvbuf[] = new double[1];
	
	//following are the args of Scatter method
	//send, offset, chunk_count, chunk_data_type, recv, offset, chunk_count, chunk_data_type, root_process_id
   	 MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.DOUBLE, recvbuf, 0, 1, MPI.DOUBLE, root);
   	 System.out.println("Processor "+rank+" has data: "+recvbuf[0]);
   	 System.out.println("Processor "+rank+" is converting feet to meters");
   	 recvbuf[0]=recvbuf[0]/3.281;
	//following are the args of Gather method
	//Object sendbuf, int sendoffset, int sendcount, Datatype sendtype,
//Object recvbuf, int recvoffset, int recvcount, Datatype recvtype,
//int root)
   	 MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.DOUBLE, sendbuf, 0, 1, MPI.DOUBLE, root);
	//display the gathered result
   	 if(rank==root){
   		System.out.println("Process 0 has data: ");
   		 for(int i=0;i<4;i++){
   			 System.out.print(sendbuf[i]+ " ");
   		 }
   	 }
	//Terminate MPI execution environment 
   	 MPI.Finalize();
    }
}





/*

aditya@ubuntu:~$ javac -cp $MPJ_HOME/lib/mpj.jar ScatterGather.java
aditya@ubuntu:~$ $MPJ_HOME/bin/mpjrun.sh -np 4 ScatterGather
MPJ Express (0.44) is started in the multicore configuration
Processor 0 has data: 10.0 20.0 30.0 40.0 
Processor 2 has data: 30.0
Processor 2 is converting feet to meters
Processor 3 has data: 40.0
Processor 3 is converting feet to meters
Processor 0 has data: 10.0
Processor 0 is converting feet to meters
Processor 1 has data: 20.0
Processor 1 is converting feet to meters
Process 0 has data: 
3.047851264858275 6.09570252971655 9.143553794574824 12.1914050594331 
aditya@ubuntu:~$ 


*/
