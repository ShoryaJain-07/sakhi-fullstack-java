import { asyncHandler } from "../utils/asyncHandler.js";
import { Blog } from "../models/blog.model.js";
import {ApiResponse} from "../utils/ApiResponse.js"

export const addBlog = asyncHandler(async (req, res) => {
    try {
      const {title, description} = req.body
    const blog = await Blog.create({
        title,
        description
    });

    if (!blog) {
      return res.json(new ApiResponse(400, error, "Blog not created"));
    }

    return res.json(new ApiResponse(200, blog, "Blog added successfully"));
  } catch (error) {
    return res.json(new ApiResponse(500, error, "internal server error"));
  }
});

export const getBlog = asyncHandler(async (req, res) => {
  try {
    const blog = await Blog.find();

    if (!blog) {
      return res.json(new ApiResponse(400, error, "Blog not found"));
    }

    return res.json(new ApiResponse(200, blog, "Blog fetched successfully"));
  } catch (error) {
    return res.json(new ApiResponse(500, error, "internal server error"));
  }
});