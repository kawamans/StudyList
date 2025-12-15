package sec4;

import sec1.CentralProcessingUnit;
import sec1.Computer;
import sec1.HardDiskDrive;
import sec1.Memory;

public class InheritanceTest {
    public static void main(String[] args) {
        // コンピュータの各構成要素をインスタンス化
        CentralProcessingUnit cpu = new CentralProcessingUnit ("Core i5", 50000);
        Memory memory = new Memory("DDR4", 20000);
        HardDiskDrive hdd = new HardDiskDrive ("500GBハードディスク", 3000);
        // コンピュータを構成要素を元にインスタンス化
        Computer pc = new Computer("Basic PC", 30000, cpu, memory, hdd);
        // 本体、各パーツ名を取得
        String pcName = pc.getName();
        String cpuName = pc.getCpu().getName();
        String memoryName = pc.getMemory().getName();
        String hddName = pc.getHdd().getName();
        int price = pc.getPrice() // PC本体価格
        		+ pc.getCpu().getPrice() // CPU価格
        		+ pc.getMemory().getPrice() // メモリ価格
        		+ pc.getHdd().getPrice(); // HDD価格
        System.out.println("パソコン名：" + pcName);
        System.out.println("CPU：" + cpuName);
        System.out.println("メモリ：" + memoryName);
        System.out.println("HDD：" + hddName);
        System.out.println("販売価格：" + price + "円");
    }
}