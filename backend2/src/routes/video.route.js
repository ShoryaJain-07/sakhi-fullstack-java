import { Router } from "express";
import { addVideo, getVideo } from "../controllers/video.controller.js";

const router = Router();

router.route("/get-video").get(getVideo);
router.route("/add-video").post(addVideo);

export default router;
