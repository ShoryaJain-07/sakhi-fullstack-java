import { Router } from "express"
import {addBlog, getBlog} from "../controllers/blog.controller.js"

const router = Router()

router.route("/add-blogs").post(addBlog)
router.route("/get-blogs").get(getBlog)

export default router