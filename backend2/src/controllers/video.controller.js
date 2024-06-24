import { asyncHandler } from "../utils/asyncHandler.js";
import { Video } from "../models/video.model.js";
import { ApiResponse } from "../utils/ApiResponse.js";

export const addVideo = asyncHandler(async (req, res) => {
    try {
      const {title, link} = req.body
    const video = await Video.create({
        title,
        link
    });

    if (!video) {
      return res.json(new ApiResponse(400, error, "Video not created"));
    }

    return res.json(new ApiResponse(200, video, "Video added successfully"));
  } catch (error) {
    return res.json(new ApiResponse(500, error, "internal server error"));
  }
});

export const getVideo = asyncHandler(async (req, res) => {
    try {
        const video = await Video.find();

        if (!video) {
            return res.json(new ApiResponse(400, error, "Video not found"));
        }

        return res.json(new ApiResponse(200, video, "Video fetched successfully"));
        
    } catch (error) {
            return res.json(
              new ApiResponse(500, error, "internal server error")
            );

    }
})
