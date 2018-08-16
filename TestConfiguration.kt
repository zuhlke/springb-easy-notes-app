@Configuration
class TestConfiguration : AbstractMongoConfiguration() {
    @Autowired
    lateinit var env: Environment

    override fun getDatabaseName() =
            env.getProperty("mongo.db.name", "test")

    override fun mongoClient(): MongoClient {
        logger.info("Instantiating Fongo with name $databaseName.")
        return Fongo(databaseName).mongo
    }

    companion object {
        val logger: Logger =
                LoggerFactory.getLogger(TestConfiguration::class.java)
    }
}