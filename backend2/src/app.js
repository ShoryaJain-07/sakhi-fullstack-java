import express from "express"
import cors from "cors"
import cookieParser from "cookie-parser"

const app = express()
app.use(cors({
    origin:process.env.CORS_ORIGIN
}))

app.use(express.json())
app.use(express.urlencoded({ extended: true }))
app.use(express.static("public"))
app.use(cookieParser())

import blogRouter from "./routes/blog.route.js"
import videoRouter from "./routes/video.route.js"
import quizRouter from "./routes/quiz.route.js"
import vaccineRouter from "./routes/vaccine.route.js"

app.use("/blog",blogRouter)
app.use("/video",videoRouter)
app.use("/quiz",quizRouter)
app.use("/vaccine",vaccineRouter)

export {app}