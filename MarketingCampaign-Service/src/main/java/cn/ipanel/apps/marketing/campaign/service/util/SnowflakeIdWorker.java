package cn.ipanel.apps.marketing.campaign.service.util;

import java.time.Instant;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-13 下午3:26
 * Modified By:
 * Description:
 */
public class SnowflakeIdWorker {

    private static SnowflakeIdWorker instance;

    public synchronized static SnowflakeIdWorker getInstance(Long workerId, Long dataCenterId) {
        if (instance == null)
            instance = new SnowflakeIdWorker(workerId, dataCenterId);
        return instance;
    }

    private Long workerId;
    private Long dataCenterId;
    private Long sequence = 0L;

    SnowflakeIdWorker(Long workerId, Long dataCenterId) {
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }

        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDataCenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    private Long twepoch = 1288834974657L;

    private Long workerIdBits = 5L;
    private Long dataCenterIdBits = 5L;
    private Long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private Long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);
    private Long sequenceBits = 12L;

    private Long workerIdShift = sequenceBits;
    private Long dataCenterIdShift = sequenceBits + workerIdBits;
    private Long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
    private Long sequenceMask = -1L ^ (-1L << sequenceBits);

    private Long lastTimestamp = -1L;

    public synchronized Long nextId() {
        Long timestamp = Instant.now().toEpochMilli();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        if (lastTimestamp.equals(timestamp)) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift)
                | (dataCenterId << dataCenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    private Long tilNextMillis(Long lastTimestamp) {
        Long timestamp = Instant.now().toEpochMilli();
        while (timestamp <= lastTimestamp) {
            timestamp = Instant.now().toEpochMilli();
        }
        return timestamp;
    }
}
