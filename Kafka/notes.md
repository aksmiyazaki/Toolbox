- Streaming platform

## Intro

### Three main capabilities
    - Publish/Subscribe streams of records - message queue
    - Store streams of records in a fault-tolerant way
    - Process streams of records as they occur

### Class of applications
    - Real time streaming data pipelines that reliably get data btw systems or apps
    - Real time streaming apps that transform or react to streams of data

- Runs as a cluster on one or more servers that can span multiple datacenters
- Stores stream of records in categories called topics
- Each record consists in a tuple <Key, Value, Timestamp>

### APIs
    - Producer API
        - Allows an app to publish stream of records to one or more topics.
    - Consumer API
        - Allows an app to subscribe to one or more topics and process the stream of records.
    - Streams API
        - Allows an app to act as a stream processor consuming an input stream from one or more topics and producing an output stream to one or more output topics (Transforming one stream to another)
    - Connector API
        - Allows reusable modules to connect to Kafka (e.g. a relational db connector that captures every change to a table).

    - All the communication in Kafka is made over TCP

## Topics and Logs

- Topic is an abstraction for a stream of records.
    - Category or feed name to which records are published
    - Are always multi-subscriber
    - For each topic, Kafka cluster maintains a partitioned log
    - Each partition is an ordered, immutable sequence of records that is continually appended to.
    - **Inside each partition, each record has a seqid number, called offset. It uniquely identifies that record within the partition**.
    - **There is no seqid between all partitions of a topic.**
    - Total order over records can be achieved with a topic with only one partition, however, this implies only one consumer per consumer group (because each consumer instance is the exclusive consumer of a partition).
    - All published records are persisted whether or not they have been consumed, using a configurable retention period. After that period, the records are discarded to free up space.
        - Ex: If retention period is 2 days, a record will be available for that time since its publish date.
    - Kafka's performance is constant with respect to data size, so storing large amounts of data isn't a performance issue.
    - The only metadata retained on a per-consumer basis is the offset of that consumer in the log.
    - The consumer is the one who controls the order of read, so it can read records in any order it likes.

## Distribution
    - Partitions of the log are distributed over servers in the cluster
    - Each server handles requests for a share of the partitions
    - Each partition is replicated across a configurable number of servers
    - Each partition has a server who acts as **leader** which manages writes and reads requests
    - The followers passively replicates the leader
    - If leader fails, a follower takes its place.

### Producers
    - Publish data to topics of their choice.
    - Responsible for choosing which record to assign to which partition in the topic.
        - This can be done in a round-robin way to load balance.

### Consumers
    - Label themselves with a Group name.
    - Each record published to a topic is delivered to one consumer instance withing each group.
    - If all consumer instances have the same group, the records will be load balanced over the instances.
    - If each instance have a different group, the records will be broadcasted over all instances.
    - Consumption is implemented in Kafka by dividing up the partitions in the log over the consumer instances. In that way, each instance is the exclusive consumer of a fair share of partitions at any point in time.

### Guarantees
    - Messages sent by a producer to a particular topic partition will be appended in the order they are sent (ordering).
    - Consumer sees records in the order they are stored in the log.

### Kafka as Messaging System
    - It can be used both as Queueing and Publish-subscribe models
        - Queuing - Consumer group allows you to divide the processing over a collection of processes
        - Broadcasting - Kafka broadcasts messages to all consumer groups
    - Every topic has both properties.
    - Stronger ordering gurantees 
    - Each partition in the topic is consumed by exacly one consumer in the group
        - This implies that it doesn't support more consumer instances in a consumer group than partitions.
        - Question: It does't work or it uses only one consumer in the group?

### Kafka as a Storage System
    - Data written to Kafka is written in disk and replicated.
    - Allows producers to wait for an ACK meaning that a write is complete (also fully replicated)

### Kafka for Stream Processing
    - Solve hard problems like handling out-of-order data, reprocessing input as code changes and performs stateful computations
    - Aggregations of streams
    - Input & output streams.

## Use Cases

### Messaging
    - Comparable to traditional messaging systems such as ActiveMQ or RabbitMQ.

### Website Activity Tracking
    - Original use case for Kafka
    - Site activity (page views, searches, other actions) is published to central topics with one topic per activity type.
    - Topics are available for subscrption for a range of use cases
        - Real-time processing
        - Real-time monitoring
        - Loading data into Hadoop or offline data warehousing sys.
    - Metrics
        - Often used for operational monitoring data.
        - Aggregation statistics of operational data to produce centralized feeds.
    - Log Aggregation
        - Centralization of logs.
    - Stream Processing
    - Event Sourcing
        - Log every state change of an app.
    - Commit Log