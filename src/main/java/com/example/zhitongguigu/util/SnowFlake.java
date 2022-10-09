package com.example.zhitongguigu.util;

import org.springframework.stereotype.Component;

@Component
public class SnowFlake {
    // Sequence, Machine , DataCenter
    // TIMESTAMP, DATACENTER, MACHINE, SEQUENCE
    private final static long SEQUENCE_BIT = 12; // 2^12

    private final static long MACHINE_BIT = 5;   // 2^5
    private final static long START_TIMESTAMP = 1609459200000L; // 2021-01-01
    private final static long DATACENTER_BIT = 5;
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    private long datacenterId = 1;
    private long machineId = 1;
    private long sequence = 0L;
    private long lastTimeStamp = -1L;

    // TIMESTAMP + DATACENTER + MACHINE + SEQUENCE
    public SnowFlake(){

    }

    public SnowFlake(long machineId, long datacenterId){
        if(datacenterId > MAX_DATACENTER_NUM || datacenterId < 0){
            throw new IllegalArgumentException("Invalid Datacenter ID");
        }
        if(machineId > MAX_MACHINE_NUM || machineId < 0){
            throw  new IllegalArgumentException("Invalid Machine ID");
        }

        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    public synchronized long nextId() {
        long currentTimeStamp = getCurrentTimeStamp();
        if (currentTimeStamp < lastTimeStamp){
            throw new RuntimeException("Invalid Timestamp");
        }

        if(lastTimeStamp == currentTimeStamp){
            sequence = (sequence + 1) & MAX_SEQUENCE;

            // sequence num has reached MAX at the same ms
            if(sequence == 0L){
                currentTimeStamp = getNextTimeStamp();
            }
        } else {
            sequence = 0L;
        }

        lastTimeStamp = currentTimeStamp;

        return (currentTimeStamp - START_TIMESTAMP) << TIMESTAMP_LEFT // TIMESTAMP
                | datacenterId << DATACENTER_LEFT   // Datacenter Id offset
                | machineId << MACHINE_LEFT  // Machine Id Offset
                | sequence; // sequence;
    }

    private long getCurrentTimeStamp(){
        return System.currentTimeMillis();
    }

    private long getNextTimeStamp(){
        long ms = getCurrentTimeStamp();
        while(ms <= lastTimeStamp){
            ms = getCurrentTimeStamp();
        }
        return  ms;
    }
}
